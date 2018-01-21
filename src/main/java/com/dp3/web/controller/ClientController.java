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
@RequestMapping("/client")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public ModelAndView getClientsView(Model model){
        List<Client> clients = clientService.getClients();
        model.addAttribute("clientList", clients);
        return new ModelAndView("client");
    }

    @GetMapping("/all")
    public List<Client> getAllClients(Model model){
        return clientService.getClients();
    }

    @PostMapping("/create")
    public ModelAndView createClient(Model model, @Valid @RequestBody Client client){
    //public ModelAndView createClient(Model model, HttpServletRequest request, HttpServletResponse response){
    //public ModelAndView createClient(Model model, @RequestBody ClientWrapper wrapper){
        clientService.createClient(client);
        model.addAttribute("clients",  clientService.getClients());
        return new ModelAndView("redirect:/client/all");
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Integer id,
                                                 @Valid @RequestBody Client client){
        Client myClient = clientService.getClientById(id);
        if (client==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientService.updateClient(myClient, client),HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteClient(Model model,@PathVariable("id") Integer id){
        clientService.delete(id);
    }

}
