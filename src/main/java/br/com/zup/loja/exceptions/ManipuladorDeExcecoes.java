package br.com.zup.loja.exceptions;

import br.com.zup.loja.dto.Erro;
import br.com.zup.loja.dto.RespostaDeErro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {
    private List <Erro> criarListaDeErros(MethodArgumentNotValidException excecao) {
        List<Erro> erros = new ArrayList<>();

        for (FieldError erro: excecao.getFieldErrors()) {
            erros.add(new Erro(erro.getField(), erro.getDefaultMessage()));
        }

        return erros;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List <Erro> erros = criarListaDeErros(ex);
        RespostaDeErro resposta = new RespostaDeErro("validacao", status, erros);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    @ExceptionHandler(ErroNoSistema.class)
    public ResponseEntity <RespostaDeErro> lidaComErrosNoSistema(ErroNoSistema erro) {
        RespostaDeErro resposta = RespostaDeErro.criaApartirDeErro(erro);
        return ResponseEntity.status(resposta.getStatusDeErro()).body(resposta);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println(ex.getMessage());
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}
