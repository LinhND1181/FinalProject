package net.aht.internship.demo.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import net.aht.internship.demo.domain.dto.UserDTO;
import net.aht.internship.demo.domain.entity.Role;
import net.aht.internship.demo.domain.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-18T23:41:21+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapEntityToDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setFullName( user.getFullName() );
        userDTO.setBirthday( user.getBirthday() );
        userDTO.setGender( user.getGender() );
        userDTO.setAddress( user.getAddress() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        Collection<Role> collection = user.getRoles();
        if ( collection != null ) {
            userDTO.setRoles( new ArrayList<Role>( collection ) );
        }
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public User mapDTOToEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getUsername() );
        user.setEmail( userDTO.getEmail() );
        user.setFullName( userDTO.getFullName() );
        user.setBirthday( userDTO.getBirthday() );
        user.setGender( userDTO.getGender() );
        user.setAddress( userDTO.getAddress() );
        user.setPhoneNumber( userDTO.getPhoneNumber() );
        Collection<Role> collection = userDTO.getRoles();
        if ( collection != null ) {
            user.setRoles( new ArrayList<Role>( collection ) );
        }
        user.setPassword( userDTO.getPassword() );

        return user;
    }
}
