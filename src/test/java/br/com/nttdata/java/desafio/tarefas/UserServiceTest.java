package br.com.nttdata.java.desafio.tarefas;

import br.com.nttdata.java.desafio.tarefas.repository.UserRepository;
import br.com.nttdata.java.desafio.tarefas.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{

   @Mock
    private UserRepository userRepository;

   @InjectMocks
    private UserService userService;

}
