package br.com.oficinapro.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=150)
    private String descricao;

    @Column(nullable=false)
    private BigDecimal valor;

    @Column(nullable=false)
    private Integer tempoEstimado;

    @Column(nullable=false)
    private Boolean ativo=true;

    public Servico(){}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao=descricao;}

    public BigDecimal getValor(){return valor;}
    public void setValor(BigDecimal valor){this.valor=valor;}

    public Integer getTempoEstimado(){return tempoEstimado;}
    public void setTempoEstimado(Integer tempoEstimado){this.tempoEstimado=tempoEstimado;}

    public Boolean getAtivo(){return ativo;}
    public void setAtivo(Boolean ativo){this.ativo=ativo;}
}