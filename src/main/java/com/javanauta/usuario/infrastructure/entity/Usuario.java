package com.javanauta.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //isso aqui é pra dizer que é uma tabela do banco de dados //
@Table(name = "usuario") //especificação do nome da tabela //
public class Usuario implements UserDetails { // User details gerencia nossos acessos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // com essas duas linhas, vai gerar automaticamente os Id's //
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL) //como se fosse um usuário para vários endereços na tabela
    @JoinColumn(name = "usuario_id", referencedColumnName = "id") // é o nome que vai constar lá no endereço relacionando o usuário
    private List<Endereco> enderecos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones;

    public Usuario(String joao, String mail, String number) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
