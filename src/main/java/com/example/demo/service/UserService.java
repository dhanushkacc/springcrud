package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class); // Map UserDTO to User entity
        userRepo.save(user); // Save using the userRepo instance
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class); // Map UserDTO to User entity
        userRepo.save(user); // Save using the userRepo instance
        return userDTO;
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

}
