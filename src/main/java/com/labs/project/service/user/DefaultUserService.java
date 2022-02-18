package com.labs.project.service.user;

import com.labs.project.persistance.user.PersistentUser;
import com.labs.project.persistance.user.UserRepository;
import com.labs.project.service.common.exception.LongOrShortPasswordException;
import com.labs.project.service.common.exception.LongOrShortUsernameException;
import com.labs.project.service.common.exception.UsernameAlreadyExistsException;
import com.labs.project.service.user.model.UserCreationParameter;
import com.labs.project.service.user.model.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository repository;

    public DefaultUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(final UserCreationParameter parameter) {
        Assert.notNull(parameter, "Null was passed as parameter 'parameter'.");
        Assert.hasText(parameter.getName(), "Null or empty text passed as parameter 'name'.");
        Assert.hasText(parameter.getSurname(), "Null or empty text passed as parameter 'surname'.");
        if ((parameter.getUsername().length() < 6 || parameter.getUsername().length() > 16) && (parameter.getUsername() != null)) {
            throw new LongOrShortUsernameException(parameter.getUsername());
        }
        if (parameter.getPassword().length() < 6 || parameter.getPassword().length() > 16 && (parameter.getPassword() != null)) {
            throw new LongOrShortPasswordException(parameter.getPassword());
        }
        if (repository.existsByUsername(parameter.getUsername())) {
            throw new UsernameAlreadyExistsException(parameter.getUsername());
        }

        final PersistentUser user = new PersistentUser(
                parameter.getName(),
                parameter.getSurname(),
                parameter.getUsername(),
                parameter.getPassword()
        );
        return repository.save(user).getId();
    }

    @Override
    public Optional<UserDetails> findById(final Long id) {
        Assert.isTrue(id > 0, "Parameter 'id' must not be negative number or zero.");
        return repository.findById(id).map(UserDetails::new);
    }
//
//    @Override
//    public UserDetails getById(final Long id) {
//        Assert.isTrue(id > 0, "Parameter 'id' must not be negative number or zero.");
//        return findById(id).orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//    @Override
//    public Optional<UserDetails> findByUsername(String username) {
//        Assert.hasText(username, "Null or empty text passed as parameter 'username'.");
//        return repository.findByUsername(username).map(UserDetails::new);
//    }
//
//    @Override
//    public UserDetails getByUsername(String username) {
//        return findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//    }
//
//    @Override
//    public UserDetails login(UserLoginParameter parameter) {
//        PersistentUser persistentUser = repository.getByUsername(parameter.getUsername());
//        if (!repository.existsByPassword(parameter.getPassword())) {
//            throw new WrongPasswordException(parameter.getPassword());
//        }
//        UserDetails userDetails = new UserDetails(
//                persistentUser
//        );
//        return userDetails;
//    }

//    private String encrypt(String text){
//
//        return null;
//    }
}
