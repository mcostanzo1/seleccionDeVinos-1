package com.dp3.service;

import com.dp3.dao.ClientRepository;
import com.dp3.dao.UserRepository;
import com.dp3.domain.Client;
import com.dp3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Client> getClients(){
        User user = getContextUser();
        if (user.isAdmin()) {
            return clientRepository.findAll();
        } else {
            return clientRepository.findByClientOwner(user);
        }
    }

    public Client createClient(Client client){
        client.setClientOwner(getContextUser());
        return clientRepository.save(client);
    }


    public Client getClientById(Integer id){
        Client client = clientRepository.findOne(id);
        return client;
    }

    public Client updateClient(Client myClient, Client clientData) {
        if (clientData.getName()!=null) myClient.setName(clientData.getName());
        if (clientData.getAddress()!=null) myClient.setAddress(clientData.getAddress());
        if (clientData.getPhone()!=null) myClient.setPhone(clientData.getPhone());
        if (clientData.getEmail()!=null) myClient.setEmail(clientData.getEmail());
        return clientRepository.save(myClient);
    }

    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    public User getContextUser() {
        User user;
        //TODO Sacar este parche:
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String){
            user = userRepository.findByUsername("nico@nico.com");
        } else {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }
}
