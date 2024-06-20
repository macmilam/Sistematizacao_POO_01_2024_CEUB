package Sistematizacao.Cartoes_MGS.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CartaoDto(@NotBlank String cpf,
						@NotBlank String nome_funcionario,
						@NotBlank String data_Nascimento,
						@NotBlank String alergias,
						@NotBlank String problemas_medicos,
						@NotBlank String tipo_sanguineo,
						@NotBlank String telefone,
						@NotBlank String email) {
	

}