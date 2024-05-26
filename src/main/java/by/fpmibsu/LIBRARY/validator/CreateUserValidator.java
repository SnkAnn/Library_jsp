package by.fpmibsu.LIBRARY.validator;

import by.fpmibsu.LIBRARY.DTO.CreateUserDto;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE=new CreateUserValidator();
    @Override
    public ValidationResult isValid(CreateUserDto object){
        var validationResult=new ValidationResult();
        if(object.getLogin().isEmpty()){
            validationResult.add(Error.of("invalid.login","Login is invalid"));
        }
        if(object.getPassword().isEmpty()){
            validationResult.add(Error.of("invalid.password","Password is invalid"));
        }

        if(object.getMail().isEmpty()){
            validationResult.add(Error.of("invalid.mail","Email is invalid"));
        }
        return validationResult;
    }
    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }

}
