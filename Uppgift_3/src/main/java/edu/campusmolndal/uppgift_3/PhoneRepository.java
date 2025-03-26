package edu.campusmolndal.uppgift_3;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PhoneRepository {
    private static final Map<Integer, Phone> phones = new HashMap<>();

    static {
        phones.put(1, new Phone(1, "iPhone 13", "Apple", 2021));
        phones.put(2, new Phone(2, "Galaxy S21", "Samsung", 2021));
    }

    public Phone findPhoneById(int id) {
        return phones.get(id);
    }

    public List<Phone> getAllPhones() {
        return new ArrayList<>(phones.values());
    }

    public String addPhone(Phone phone) {
        phones.put(phone.getId(), phone);
        return "Phone added successfully!";
    }

    public String updatePhone(int id, Phone phone) {
        phones.put(id, phone);
        return "Phone updated successfully!";
    }

    public String deletePhone(int id) {
        phones.remove(id);
        return "Phone deleted successfully!";
    }
}
