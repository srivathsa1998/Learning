package com.example.Demo.controllers;

import com.example.Demo.beans.Patient;
import com.example.Demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/getpatients")
    public List<Patient> getPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/getpatients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value="id") int id){
        try{
            Patient patient=patientService.getPatientById(id);
            return new ResponseEntity<Patient>(patient,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getpatients/patientname")
    public ResponseEntity<Patient> getPatientByNAme(@RequestParam(value="name") String patientName){
        try{
            Patient patient=patientService.getPatientByName(patientName);
            return new ResponseEntity<Patient>(patient,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addpatient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping("/updatepatient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") int id,@RequestBody Patient patient){
        try{
            Patient existPatient=patientService.getPatientById(id);
            existPatient.setName(patient.getName());
            existPatient.setGender(patient.getGender());
            existPatient.setPrescription(patient.getPrescription());

            Patient updated_patient=patientService.updatePatient(existPatient);
            return new ResponseEntity<Patient>(updated_patient,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deletepatient/{id}")
    public AddResponse deletePatient(@PathVariable(value = "id") int id){
        return patientService.deletePatient(id);
    }
}
