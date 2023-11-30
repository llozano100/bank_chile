package com.bank.user.service;

import com.bank.user.constans.Message;
import com.bank.user.dto.request.UserDto;
import com.bank.user.dto.response.UserResponse;
import com.bank.user.entity.Phone;
import com.bank.user.entity.User;
import com.bank.user.property.Property;
import com.bank.user.repository.PhoneRepository;
import com.bank.user.repository.UserRepository;
import com.bank.user.util.Generic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public UserResponse saveUser(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        String regPattern = "^(.+)@(\\S+)$";
        //if(Generic.patternMatches(userDto.getEmail(),property.getRegularExpresion())){

        if(!Generic.patternMatches(userDto.getEmail(),regPattern)){
            return null;
        }
        User userData =userRepository.findByEmail(userDto.getEmail());
        User userSaveData = new User();
        if(Optional.ofNullable(userData).isEmpty()){
            userSaveData = saveUserInDB(userDto);

            userResponse.setUuid(userSaveData.getUuid());
            userResponse.setCreationDate(userSaveData.getCreatedDateSave());
            userResponse.setModifiedDate(userSaveData.getUpdatedDateSave());
            userResponse.setLastLogin(userSaveData.getLastLoginDate());
            userResponse.setToken(userSaveData.getToken());
            userResponse.setIsActive(userSaveData.getIsActive());
        }else{
            userResponse.setMessage(Message.ERROR_USER);
        }

        return userResponse;
    }

    private User saveUserInDB(UserDto userDto){
        User userSaveData = new User();
        String[] fullNameSplit = userDto.getFullName().split(" ");

        userSaveData.setUuid(Generic.generateUUID());
        userSaveData.setFirstName(fullNameSplit[0]);
        userSaveData.setLastName(fullNameSplit[1]);
        userSaveData.setCreatedDateSave(Generic.getCurrentDate());
        userSaveData.setUpdatedDateSave(userSaveData.getCreatedDateSave());
        userSaveData.setEmail(userDto.getEmail());
        userSaveData.setPassword(userDto.getPassword());
        userSaveData.setIsActive(true);


        userRepository.saveAndFlush(userSaveData);

        List<Phone> phones = new ArrayList<>();
        userDto.getPhones().forEach(phone -> {
            Phone savePhone = new Phone();
            savePhone.setPhoneNumber(phone.getNumber());
            savePhone.setCityCode(phone.getCityCode());
            savePhone.setCountryCode(phone.getCountryCode());
            savePhone.setUser(userSaveData);
            phones.add(savePhone);
            phoneRepository.saveAndFlush(savePhone);
        });

        userSaveData.setItems(phones);

        return userSaveData;
    }
}



