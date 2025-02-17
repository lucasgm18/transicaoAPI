package com.lucasgm.transacao_api.business.services.mappers;

import com.lucasgm.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.lucasgm.transacao_api.infrasctructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

     public void adiconarTransacoes(TransacaoRequestDTO dto){

         log.info("Iniciando o processamento de gravar transações");

         if (dto.dataHora().isAfter(OffsetDateTime.now())){
             log.error("Data e hora maiores que a data atual");
             throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
         }
         if (dto.valor() < 0){
             log.error("Valor não pode ser menor que 0");
             throw new UnprocessableEntity("Valor não pode ser menor que 0")
         }

         listaTransacoes.add(dto);
     }








}
