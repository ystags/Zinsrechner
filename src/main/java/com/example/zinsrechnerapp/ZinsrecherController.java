package com.example.zinsrechnerapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ZinsrecherController {


    @GetMapping("/")
    public String index(Model model, @Valid InputForm inputForm, BindingResult errors){
        model.addAttribute("inputForm", inputForm);
        Ergebnis ergebnis =  new Ergebnis(inputForm.getAnfangskapital(),
                inputForm.getZinssatz(), inputForm.getLaufzeit());
        List<OutputTable> output = ergebnis.getOutputTables();
        if(!output.isEmpty()){
            model.addAttribute("endk", output.stream().mapToDouble(OutputTable::endkapital).max().getAsDouble());
        }
        if(!errors.hasErrors()){
            model.addAttribute("ergebnisse", ergebnis);
        }

        return "index";
    }
}
