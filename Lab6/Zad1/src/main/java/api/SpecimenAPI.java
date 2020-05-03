package api;

import model.Specimen;

import java.util.List;

public interface SpecimenAPI {
    List<Specimen> getAllSpecimens();
    List<Object[]> getSpecimensForLoan();
    void addSpecimen(Specimen specimen);
    void deleteSpecimen(int id);
    void updateSpecimen(int id, Specimen specimen);
    Specimen getSpecimen(int id);
}
