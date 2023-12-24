package com.example.feignsecond.web;

import com.example.feignsecond.dto.CarStoreDto;
import com.example.feignsecond.dto.IlErrorDto;
import com.example.feignsecond.service.CarStoreService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
@OpenAPIDefinition(info = @Info(
        title = "Car controller for processing requests",
        description = "This controller allows to save and find car by id",
        version = "0.0.1",
        summary = "Summary"
))
public class CarController {

    private final CarStoreService service;

    @PostMapping
    @Operation(
            tags = "CRUD",
            description = "Too lazy for filling description",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car saved successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                    implementation = CarStoreDto.class
                            ))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "something went wrong",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = IlErrorDto.class
                                    )
                            )
                    )
            })

    public CarStoreDto save(@RequestBody CarStoreDto dto) {
        return service.carReg(dto);
    }

    @GetMapping("/find/{id}")
    public CarStoreDto findById(@PathVariable(name = "id") Integer id) {
        return service.findById(id);
    }

}

