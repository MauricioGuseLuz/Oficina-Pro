package br.com.oficinapro.model;

import br.com.oficinapro.enums.StatusOrdemServico;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    private LocalDateTime previsaoEntrega;

    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrdemServico status;

    @Column(nullable = false)
    private Integer quilometragemEntrada;

    private Integer quilometragemSaida;

    @Column(length = 1000)
    private String problemaRelatado;

    @Column(length = 1000)
    private String diagnostico;

    @Column(length = 1000)
    private String observacoes;

    @Column(nullable = false)
    private BigDecimal valorPecas = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal valorServicos = BigDecimal.ZERO;

    @PrePersist
    public void prePersist() {

        if (dataEntrada == null) {
            dataEntrada = LocalDateTime.now();
        }

        if (status == null) {
            status = StatusOrdemServico.ABERTA;
        }

        if (valorPecas == null) {
            valorPecas = BigDecimal.ZERO;
        }

        if (valorServicos == null) {
            valorServicos = BigDecimal.ZERO;
        }

        if (desconto == null) {
            desconto = BigDecimal.ZERO;
        }

        valorTotal = valorPecas
                .add(valorServicos)
                .subtract(desconto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalDateTime previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemServico status) {
        this.status = status;
    }

    public Integer getQuilometragemEntrada() {
        return quilometragemEntrada;
    }

    public void setQuilometragemEntrada(Integer quilometragemEntrada) {
        this.quilometragemEntrada = quilometragemEntrada;
    }

    public Integer getQuilometragemSaida() {
        return quilometragemSaida;
    }

    public void setQuilometragemSaida(Integer quilometragemSaida) {
        this.quilometragemSaida = quilometragemSaida;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public void setProblemaRelatado(String problemaRelatado) {
        this.problemaRelatado = problemaRelatado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigDecimal getValorPecas() {
        return valorPecas;
    }

    public void setValorPecas(BigDecimal valorPecas) {
        this.valorPecas = valorPecas;
    }

    public BigDecimal getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(BigDecimal valorServicos) {
        this.valorServicos = valorServicos;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Column(nullable = false)
    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal valorTotal = BigDecimal.ZERO;

    public OrdemServico() {
        this.dataEntrada = LocalDateTime.now();
        this.status = StatusOrdemServico.ABERTA;
    }
}