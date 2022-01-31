package com.example.Demo.services;

import com.example.Demo.beans.Patient;
import com.example.Demo.controllers.AddResponse;
import com.example.Demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
@Service
public class PatientService {

    @Autowired
    PatientRepository patientrep;
    public List<Patient> getAllPatients(){
        return patientrep.findAll();
    }

    public Patient getPatientById(int id){
        return patientrep.findById(id).get();
    }

    public Patient getPatientByName(String patientName){
        List<Patient> patients=patientrep.findAll();
        Patient patient=null;
        for(Patient pat:patients)
        {
            if(pat.getName().equals(patientName))
                patient=pat;
        }
        return patient;
    }

    public Patient addPatient(Patient patient){
        patient.setId(getMaxId());
        patientrep.save(patient);
        return patient;
    }

    public int getMaxId(){
        return patientrep.findAll().size()+1;
    }

    public Patient updatePatient(Patient patient){
        patientrep.save(patient);
        return patient;
    }

    public AddResponse deletePatient(int id){
        patientrep.deleteById(id);
        AddResponse res=new AddResponse();
        res.setMsg("Patient Deleted!");
        res.setId(id);
        return res;
    }
}
