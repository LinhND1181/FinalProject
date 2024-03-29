package net.aht.internship.demo.application.service.user_detail;

import net.aht.internship.demo.application.constants.DevMessageConstant;
import net.aht.internship.demo.application.repository.IUserRepository;
import net.aht.internship.demo.config.exception.VsException;
import net.aht.internship.demo.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (ObjectUtils.isEmpty(user)) {
            throw new VsException(DevMessageConstant.Common.OBJECT_IS_EMPTY);
        }
        return UserDetailImpl.mapRolesToAuthorities(user);
    }
}
