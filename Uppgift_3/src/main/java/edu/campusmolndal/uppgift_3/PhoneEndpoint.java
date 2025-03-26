package edu.campusmolndal.uppgift_3;

import edu.campusmolndal.uppgift_3.generated.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PhoneEndpoint {
    private static final String NAMESPACE_URI = "http://example.org/phones";

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneEndpoint(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddPhoneRequest")
    @ResponsePayload
    public AddPhoneResponse addPhone(@RequestPayload AddPhoneRequest request) {
        Phone phone = new Phone(0, request.getName(), request.getBrand(), request.getYear());
        String status = phoneRepository.addPhone(phone);
        AddPhoneResponse response = new AddPhoneResponse();
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPhoneRequest")
    @ResponsePayload
    public GetPhoneResponse getPhone(@RequestPayload GetPhoneRequest request) {
        Phone phone = phoneRepository.findPhoneById(request.getPhoneId());
        GetPhoneResponse response = new GetPhoneResponse();
        if (phone != null) {
            response.setName(phone.getName());
            response.setBrand(phone.getBrand());
            response.setYear(phone.getYear());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdatePhoneRequest")
    @ResponsePayload
    public UpdatePhoneResponse updatePhone(@RequestPayload UpdatePhoneRequest request) {
        Phone phone = new Phone(request.getPhoneId(), request.getName(), request.getBrand(), request.getYear());
        String status = phoneRepository.updatePhone(request.getPhoneId(), phone);
        UpdatePhoneResponse response = new UpdatePhoneResponse();
        response.setStatus(status);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeletePhoneRequest")
    @ResponsePayload
    public DeletePhoneResponse deletePhone(@RequestPayload DeletePhoneRequest request) {
        String status = phoneRepository.deletePhone(request.getPhoneId());
        DeletePhoneResponse response = new DeletePhoneResponse();
        response.setStatus(status);
        return response;
    }
}
