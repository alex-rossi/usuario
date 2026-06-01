package com.javanauta.usuario.infrastructure.repository;


import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // aqui é referenciado o nome da tabela no caso Usuario, e o tipo do ID no caso long

    // script "exists", retorna um boolean e verifica se o dado existe no banco de dados ou não: //
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    @Transactional // notação obrigatória para não dar nenhum erro ao deletar
    void deleteByEmail(String email);
}
