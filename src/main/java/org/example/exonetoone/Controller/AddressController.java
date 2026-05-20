package org.example.exonetoone.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exonetoone.Api.ApiResponse;
import org.example.exonetoone.Model.Address;
import org.example.exonetoone.Model.Teacher;
import org.example.exonetoone.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer-profile")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @PostMapping("/add/{teacherid}")
    public ResponseEntity<?> add(@PathVariable Integer teacherid, @RequestBody @Valid Address address){
        addressService.add(teacherid,address);
        return ResponseEntity.status(200).body(new ApiResponse("Address added successfully"));
    }

    @PutMapping("/update/{addressid}")
    public ResponseEntity<?> update(@PathVariable Integer addressid,@RequestBody @Valid Address address){
        addressService.update(addressid,address);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        addressService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted successfully"));
    }
}
