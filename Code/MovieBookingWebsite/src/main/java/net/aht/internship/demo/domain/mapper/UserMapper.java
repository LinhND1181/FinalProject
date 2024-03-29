package net.aht.internship.demo.domain.mapper;

import net.aht.internship.demo.application.service.impl.UserServiceImpl;
import net.aht.internship.demo.domain.dto.UserDTO;
import net.aht.internship.demo.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = UserServiceImpl.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "avatar", target = "avatar", ignore = true)
    @Mapping(source = "roles", target = "roles")
    UserDTO mapEntityToDTO(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "fullName", target = "fullName")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "avatar", target = "avatar", ignore = true)
    @Mapping(source = "roles", target = "roles")
    User mapDTOToEntity(UserDTO userDTO);

//    List<UserDTO> listUserModelToDto(List<User> users);
//
//    List<User> listUserDtoToModel(List<UserDTO> userDTOList);

}
