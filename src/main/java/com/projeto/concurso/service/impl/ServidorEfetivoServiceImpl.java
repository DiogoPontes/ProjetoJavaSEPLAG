package com.projeto.concurso.service.impl;

import com.projeto.concurso.dto.ServidorEfetivoInfoDTO;
import com.projeto.concurso.model.FotoPessoa;
import com.projeto.concurso.model.ServidorEfetivo;
import com.projeto.concurso.repository.FotoPessoaRepository;
import com.projeto.concurso.repository.LotacaoRepository;
import com.projeto.concurso.repository.ServidorEfetivoRepository;
import com.projeto.concurso.service.ServidorEfetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServidorEfetivoServiceImpl implements ServidorEfetivoService {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    @Override
    public ServidorEfetivo salvar(ServidorEfetivo servidor) {
        return servidorEfetivoRepository.save(servidor);
    }

    @Override
    public List<ServidorEfetivo> listarTodos() {
        return servidorEfetivoRepository.findAll();
    }

    @Override
    public Optional<ServidorEfetivo> buscarPorId(Long id) {
        return servidorEfetivoRepository.findById(id);
    }

    @Override
    public void deletar(Long id) {
        servidorEfetivoRepository.deleteById(id);
    }

    @Override
    public List<ServidorEfetivoInfoDTO> buscarPorUnidade(Long unidadeId) {
        List<ServidorEfetivo> servidores = servidorEfetivoRepository.findAll();

        return servidores.stream()
                .filter(se -> se.getPessoa() != null &&
                        se.getPessoa().getId() != null &&
                        lotacaoRepository.existsByPessoaIdAndUnidadeId(se.getPessoa().getId(), unidadeId))
                .map(se -> {
                    String nome = se.getPessoa().getNome();

                    Integer idade = calcularIdade(se.getPessoa().getDataNascimento());

                    String unidade = lotacaoRepository.findByPessoaId(se.getPessoa().getId())
                            .stream()
                            .filter(l -> l.getUnidade().getId().equals(unidadeId))
                            .map(l -> l.getUnidade().getNome())
                            .findFirst().orElse("Não informada");

                    String foto = fotoPessoaRepository.findByPessoaId(se.getPessoa().getId())
                            .stream()
                            .map(FotoPessoa::getFp_hash)
                            .findFirst().orElse(null);

                    return new ServidorEfetivoInfoDTO(nome, idade, unidade, foto);
                })
                .collect(Collectors.toList());
    }

    private Integer calcularIdade(LocalDate nascimento) {
        return (nascimento != null) ? Period.between(nascimento, LocalDate.now()).getYears() : null;
    }
}
