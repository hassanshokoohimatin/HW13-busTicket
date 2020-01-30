package ir.sunsor.repositories;

import ir.sunsor.config.CrudRepository;
import ir.sunsor.entities.Ticket;

public class TicketRepository extends CrudRepository<Ticket , Long> {

    private static TicketRepository ticketRepository;

    private TicketRepository(){}

    public static TicketRepository getInstance(){
        if (ticketRepository == null)
            ticketRepository = new TicketRepository();
        return ticketRepository;
    }

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
