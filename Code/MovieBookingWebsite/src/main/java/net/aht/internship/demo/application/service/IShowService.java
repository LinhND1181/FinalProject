package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShowService {

    Page<Show> getAllShows(Pageable pageable);

    List<Show> getAllShows();

    Show getShowById(Long showId);

    void addShow(Show newShow);

    void updateShow(Show updatedShow);

    void deleteShow(Long showId);

    void setShowActiveFlag(Long showId, boolean activeFlag);

    Page<Show> searchShows(UserSearchDTO userSearchDTO, Pageable pageable);

    Page<Show> getAllShowsByCinemaRoomId(Long cinemaRoomId, UserSearchDTO userSearchDTO, Pageable page);

    Show getShowByCode(String code);

}
