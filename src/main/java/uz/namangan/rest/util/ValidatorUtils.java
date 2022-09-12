package uz.namangan.rest.util;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.ValidationFacade;
import com.jfoenix.validation.base.ValidatorBase;

import javafx.scene.control.TextField;
import uz.namangan.rest.service.UserService;
import uz.namangan.rest.validators.*;

public class ValidatorUtils {
	
	public static RequiredFieldValidator addRequiredValidator(JFXTextField textField, String message) {
		return (RequiredFieldValidator) addValidator(new RequiredFieldValidator(), textField, message);
	}
	
	public static <T> ValidationFacade addRequiredValidator(JFXComboBox<T> comboBox, String message) {
		return addValidator(new RequiredFieldValidator(), comboBox, message);
	}
	
	public static RequiredFieldValidator addRequiredValidator(JFXPasswordField textField, String message) {
		return (RequiredFieldValidator) addValidator(new RequiredFieldValidator(), textField, message);
	}
	
	public static DuplicateUserValidator addDuplicateUserValidator(JFXTextField textField, String message, UserService user) {
		return (DuplicateUserValidator) addValidator(new DuplicateUserValidator(user), textField, message);
	}
	
	public static EmailValidator addEmailValidator(JFXTextField textField, String message) {
		return (EmailValidator) addValidator(new EmailValidator(), textField, message);
	}
	
	public static PasswordAndConfirmPasswordValidator addPasswordAndConfirmPasswordValidator(JFXPasswordField passwordTextField, JFXPasswordField confirmPasswordTextField, String message) {
		PasswordAndConfirmPasswordValidator passwordAndConfirmPasswordValidator = new PasswordAndConfirmPasswordValidator(passwordTextField, confirmPasswordTextField);
		
		passwordAndConfirmPasswordValidator.setMessage(message);
		
		passwordTextField.getValidators().add(passwordAndConfirmPasswordValidator);
		confirmPasswordTextField.getValidators().add(passwordAndConfirmPasswordValidator);
		
		return passwordAndConfirmPasswordValidator;
	}
	
	public static NumberValidator addNumberOnlyValidator(TextField textField) {
		NumberValidator numberValidator = new NumberValidator(textField);
		numberValidator.validate();
		
		return numberValidator;
	}
	
	public static DecimalValidator addDecimalValidator(TextField textField) {
		DecimalValidator decimalValidator = new DecimalValidator(textField);
		decimalValidator.validate();
		
		return decimalValidator;
	}
	
	public static MoneyValidator addMoneyValidator(TextField textField) {
		MoneyValidator moneyValidator = new MoneyValidator(textField);
		moneyValidator.validate();
		
		return moneyValidator;
	}
	
	public static MaxLengthValidator addMaxLengthValidator(TextField textField, int maxLength) {
		MaxLengthValidator maxLengthValidator = new MaxLengthValidator(textField);
		maxLengthValidator.validate(maxLength);
		
		return maxLengthValidator;
	}
	
	private static ValidatorBase addValidator(ValidatorBase validatorBase, JFXTextField textField, String message) {
		
		if (message != null) {
			validatorBase.setMessage(message);
		}
		
		textField.getValidators().add(validatorBase);
		
		return validatorBase;
	}
	
	private static ValidatorBase addValidator(ValidatorBase validatorBase, JFXPasswordField textField, String message) {
		
		if (message != null) {
			validatorBase.setMessage(message);
		}
		
		textField.getValidators().add(validatorBase);
		
		return validatorBase;
	}
	
	@SuppressWarnings("static-access")
	private static <T> ValidationFacade addValidator(ValidatorBase validatorBase, JFXComboBox<T> comboBox, String message) {
		
		if (message != null) {
			validatorBase.setMessage(message);
		}
		
		ValidationFacade validationFacade = new ValidationFacade();
	    validationFacade.setControl(comboBox);
	    validationFacade.getValidators().add(validatorBase);
		
	    comboBox.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
            	validationFacade.validate(comboBox);
            }
        });
	    
		return validationFacade;
	}
	
	

}
