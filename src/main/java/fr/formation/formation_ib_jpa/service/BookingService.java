package fr.formation.formation_ib_jpa.service;

import fr.formation.formation_ib_jpa.dao.BookingDao;
import fr.formation.formation_ib_jpa.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Transactional
    public Booking save(Booking booking){
        return bookingDao.save(booking);
    }

    @Transactional
    public void deleteById(Long bookingId){
        bookingDao.deleteById(bookingId);
    }

    public Booking findById(Long id){
        Optional<Booking> booking = bookingDao.findById(id);
        if(booking.isPresent()){
            return booking.get();
        }
        return null;
    }

    public Booking findByIdWithCustomer(Long id) {
        return bookingDao.findByIdWithCustomer(id);
    }
}
