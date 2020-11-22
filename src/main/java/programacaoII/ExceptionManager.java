package programacaoII;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import programacaoII.motorista.IdDiferenteException;
import programacaoII.motorista.ItemFoiDuplicadoException;
import programacaoII.motorista.MotoristaNaoAchadoException;



@ControllerAdvice
public class ExceptionManager {
	
    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class, MotoristaNaoAchadoException.class})
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ItemFoiDuplicadoException.class)
    public ResponseEntity<Void> handleConflict() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(IdDiferenteException.class)
    public ResponseEntity<Void> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
