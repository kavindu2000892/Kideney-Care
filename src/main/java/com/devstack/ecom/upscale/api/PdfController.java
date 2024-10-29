package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestDoctorDto;
import com.devstack.ecom.upscale.entity.Pdf;
import com.devstack.ecom.upscale.repo.PdfRepo;
import com.devstack.ecom.upscale.service.DoctorService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pdf")
@CrossOrigin(origins = "http://localhost:4200")
public class PdfController {
    @Autowired
    private PdfRepo pdfRepo;

    @PostMapping
    public ResponseEntity<Pdf> createNewPdf(@RequestParam String name, @RequestPart("file") MultipartFile file) throws IOException {
        Pdf pdf=Pdf.builder().userName(name).displayPicture(file.getBytes()).build();
        pdfRepo.save(pdf);
        pdf.setDisplayPicture(null);
        return  ResponseEntity.ok(pdf);
    }

    @GetMapping
    public  ResponseEntity<List<Pdf>> getAllPdf(){
        List<Pdf> pdfList = pdfRepo.findAll();
        return  ResponseEntity.ok(pdfList);

    }

}
