//package miu.edu.cse.adsdentalsurgeries.dentist.controller;
//
//import com.google.gson.Gson;
//import miu.edu.cse.adsdentalsurgeries.dentist.dto.request.DentistRequestDto;
//import miu.edu.cse.adsdentalsurgeries.dentist.dto.response.DentistResponseDto;
//import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;
//import miu.edu.cse.adsdentalsurgeries.dentist.service.DentistService;
//import miu.edu.cse.adsdentalsurgeries.user.dto.request.UserRequestDto;
//import miu.edu.cse.adsdentalsurgeries.user.dto.response.UserResponseDto;
//import miu.edu.cse.adsdentalsurgeries.user.model.Role;
//import miu.edu.cse.adsdentalsurgeries.user.model.User;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@WebMvcTest(DentistController.class)
//class DentistControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private DentistService dentistService;
//
//    @Test
//    void addDentist() throws Exception {
//        DentistRequestDto dentist = new DentistRequestDto();
//        dentist.setUserRequestDto(new UserRequestDto("Kev", "chem", "6412339752", "kchemutai@gmail.com", "pass", Role.ADMIN));
//        dentist.setSpecialization("dental");
//
//        DentistResponseDto dentistResponseDto = new DentistResponseDto();
//        dentistResponseDto.setSpecialization("Gum");
//        dentistResponseDto.setUserResponseDto(new UserResponseDto("Kev", "chem", "6412339752", "kchemutai@gmail.com", "pass", Role.ADMIN));
//
//        Mockito.when(dentistService.createNewDentist(Mockito.any(DentistRequestDto.class))).thenReturn(Optional.of(dentistResponseDto));
//
//        mockMvc.perform(
//                        MockMvcRequestBuilders.post("/api/v1/dentists")
//                                .contentType("application/json")
//                                .content(new Gson().toJson(dentist))
//                )
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//}