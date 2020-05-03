package beans;

import lombok.Getter;
import lombok.Setter;
import model.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "SearchBean")
@ViewScoped
@Getter
@Setter
public class SearchBean {

    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;

    String readerName;
    String readerSurname;
    String bookTitle;
    String isbn;
    String categoryName;
    String authorName;
    String authorSurname;
    Date startDate;
    Date endDate;

    List<String> chosenGroupings;
    List<String> treatAsLike;

    boolean classicSearch = true;

    List<Object[]> classicQueryResultList;
    List<Object[]> groupQueryResultList = new LinkedList<Object[]>();

    public void executeGroupingSearch()
    {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);

        Root<Loan> loan = criteriaQuery.from(Loan.class);
        Join<Loan, Reader> reader = loan.join("loan_reader");
        Join<Loan, Specimen> specimen = loan.join("loan_specimen");
        Join<Specimen, Book> book = specimen.join("specimen_book");
        Join<Book,Author> author = book.join("book_author");
        Join<Book,Category> category = book.join("book_category");

        List<Expression> groupings = new ArrayList<Expression>();
        List<Selection> selections = new ArrayList<Selection>();
        List<Predicate> where = new ArrayList<Predicate>();

        selections.add(criteriaBuilder.count(loan));

        if(chosenGroupings.contains("reader_name")){
            groupings.add(reader.get("reader_name"));
            selections.add(reader.get("reader_name"));}
        if(chosenGroupings.contains("reader_surname")){
            groupings.add(reader.get("reader_surname"));
            selections.add(reader.get("reader_surname"));}
        if(chosenGroupings.contains("book_title")){
            groupings.add(book.get("book_title"));
            selections.add(book.get("book_title"));}
        if(chosenGroupings.contains("isbn")){
            groupings.add(book.get("isbn"));
            selections.add(book.get("isbn"));}
        if(chosenGroupings.contains("category_name")){
            groupings.add(category.get("category_name"));
            selections.add(category.get("category_name"));}
        if(chosenGroupings.contains("author_name")){
            groupings.add(author.get("author_name"));
            selections.add(author.get("author_name"));}
        if(chosenGroupings.contains("author_surname")){
            groupings.add(author.get("author_surname"));
            selections.add(author.get("author_surname"));}
        if(startDate!=null)
            where.add(criteriaBuilder.greaterThanOrEqualTo(loan.<Comparable>get("loan_start_date"),startDate));
        if(endDate!=null)
            where.add(criteriaBuilder.lessThanOrEqualTo(loan.<Comparable>get("loan_end_date"),endDate));



        criteriaQuery
                .multiselect(selections.toArray(new Selection[]{}))
                .where(where.toArray(new Predicate[]{}))
                .groupBy(groupings.toArray(new Expression[]{}));

        TypedQuery<Object[]> typedQuery = em.createQuery(criteriaQuery);
        List<Object[]> notProcessedResultList = typedQuery.getResultList();

        groupQueryResultList.clear();
        for(Object[] objects: notProcessedResultList)
        {
            StringBuilder tmp = new StringBuilder();
            for(int i=1;i<objects.length;i++){
                tmp.append(objects[i]+", ");
            }
            groupQueryResultList.add(new Object[]{tmp,objects[0]});
        }
    }

    public void executeClassicSearch()
    {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Loan> loan = criteriaQuery.from(Loan.class);
        Join<Loan, Reader> reader = loan.join("loan_reader");
        Join<Loan, Specimen> specimen = loan.join("loan_specimen");
        Join<Specimen, Book> book = specimen.join("specimen_book");
        Join<Book, Author> author = book.join("book_author");
        Join<Book,Category> category = book.join("book_category");

        List<Predicate> conditions = new ArrayList<Predicate>();
        if(readerName!=null && !readerName.equals("")){
            if(treatAsLike.contains("reader_name"))
                conditions.add(criteriaBuilder.like(reader.<String>get("reader_name"),readerName));
            else
                conditions.add(criteriaBuilder.equal(reader.get("reader_name"),readerName));
        }
        if(readerSurname!=null && !readerSurname.equals("")){
            if(treatAsLike.contains("reader_surname"))
                conditions.add(criteriaBuilder.like(reader.<String>get("reader_surname"),readerSurname));
            else
                conditions.add(criteriaBuilder.equal(reader.get("reader_surname"),readerSurname));
        }
        if(bookTitle!=null && !bookTitle.equals("")){
            if(treatAsLike.contains("book_title")){
                conditions.add(criteriaBuilder.like(book.<String>get("book_title"),bookTitle));
                System.out.println(bookTitle);}
            else
                conditions.add(criteriaBuilder.equal(book.get("book_title"),bookTitle));
        }
        if(isbn!=null && !isbn.equals("")){
            if(treatAsLike.contains("isbn"))
                conditions.add(criteriaBuilder.like(book.<String>get("isbn"),isbn));
            else
                conditions.add(criteriaBuilder.equal(book.get("isbn"),isbn));}
        if(categoryName!=null && !categoryName.equals("")){
            if(treatAsLike.contains("category_name"))
                conditions.add(criteriaBuilder.like(category.<String>get("category_name"),categoryName));
            else
                conditions.add(criteriaBuilder.equal(category.get("category_name"),categoryName));}
        if(authorName!=null && !authorName.equals("")){
            if(treatAsLike.contains("author_name"))
                conditions.add(criteriaBuilder.like(author.<String>get("author_name"),authorName));
            else
                conditions.add(criteriaBuilder.equal(author.get("author_name"),authorName));}
        if(authorSurname!=null && !authorSurname.equals("")){
            conditions.add(criteriaBuilder.equal(author.get("author_surname"),authorSurname));}
        if(startDate!=null)
            conditions.add(criteriaBuilder.greaterThanOrEqualTo(loan.<Comparable>get("loan_start_date"),startDate));
        if(endDate!=null)
            conditions.add(criteriaBuilder.lessThanOrEqualTo(loan.<Comparable>get("loan_end_date"),endDate));

        criteriaQuery
                .multiselect(reader.get("reader_name"),
                        reader.get("reader_surname"),
                        book.get("book_title"),book.get("isbn"),
                        category.get("category_name"),
                        author.get("author_name"),
                        author.get("author_surname"),
                        loan.get("loan_start_date"),
                        loan.get("loan_end_date"))
                .where(conditions.toArray(new Predicate[]{}));

        TypedQuery<Object[]> typedQuery = em.createQuery(criteriaQuery);
        classicQueryResultList = typedQuery.getResultList();
    }
}
