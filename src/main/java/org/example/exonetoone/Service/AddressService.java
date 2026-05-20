package org.example.exonetoone.Service;

import lombok.RequiredArgsConstructor;
import org.example.exonetoone.Api.ApiException;
import org.example.exonetoone.Model.Address;
import org.example.exonetoone.Model.Teacher;
import org.example.exonetoone.Repository.AddressRepository;
import org.example.exonetoone.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public void add(Integer teacherid,Address address){
        Teacher teacher=teacherRepository.findTeacherById(teacherid);
        if (teacher==null)
            throw new ApiException("Teacher not found");
        address.setTeacherid(teacher);
        addressRepository.save(address);
    }

    public void delete(Integer id){
        Address address=addressRepository.findAddressById(id);
        if (address==null)
            throw new ApiException("Address not found");
        addressRepository.deleteAddressById(id);
    }

    public void update(Integer id,Address address){
        Address oldAddress=addressRepository.findAddressById(id);

        if (oldAddress==null)
            throw new ApiException("Address not found");
        oldAddress.setArea(address.getArea());
        oldAddress.setStreet(address.getStreet());
        oldAddress.setBuilding_number(address.getBuilding_number());
        addressRepository.save(oldAddress);

    }


}
