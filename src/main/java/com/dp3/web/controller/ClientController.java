package com.dp3.web.controller;

import com.dp3.domain.Client;
import com.dp3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public ModelAndView getClientsView(Model model){
        List<Client> clients = clientService.getClients();
        model.addAttribute("client", new Client());
        model.addAttribute("clientList", clients);
        return new ModelAndView("client");
    }

    @GetMapping("/all")
    public List<Client> getAllClients(Model model){
        return clientService.getClients();
    }

    @PostMapping("/create")
    public ModelAndView createClient(Model model, @Valid @ModelAttribute Client client){
        clientService.createClient(client);
        return new ModelAndView("redirect:/clients/");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> getClientByClientName(@PathVariable("id") Integer id){
        Client client = clientService.getClientById(id);
        if (client==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/{id}/edit")
    public ModelAndView updateClient(@PathVariable("id") Integer id,
                                                 @Valid @ModelAttribute Client client){
        Client myClient = clientService.getClientById(id);
        if (client!=null){
            clientService.updateClient(myClient, client);
        }
        return new ModelAndView("redirect:/clients/");
        //return new ResponseEntity<>(clientService.updateClient(myClient, client),HttpStatus.OK);
    }


    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteClient(Model model,@PathVariable("id") Integer id){
        clientService.delete(id);
        return new ModelAndView("redirect:/clients/");
    }

}
