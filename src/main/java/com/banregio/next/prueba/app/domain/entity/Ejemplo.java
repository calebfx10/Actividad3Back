package com.banregio.next.prueba.app.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.banregio.next.prueba.remoto.dto.UsuarioSibamex;
import com.banregio.next.postgre.domain.entity.PostgreEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que mapea una tabla en BD, si es requerido deben especificarse los
 * indices, contraints, relaciones, etc.
 * @author ${user}
 * @since ${date}
 */
@Getter
@Setter
@Entity
@ApiModel(description = "Descripci\u00F3n de la tabla")
@Table(name = "ejemplo", indexes = { @Index(name = "ejemplo_id_idx", columnList = "id") })
public class Ejemplo extends PostgreEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	@ApiModelProperty(value = "Descripci\u00F3n del campo")
	private Date fecha;

	@Column(name = "campo_string")
	@ApiModelProperty(value = "Descripci\u00F3n del campo")
	private String campoString;

	@Column(name = "campo_entero")
	@ApiModelProperty(value = "Descripci\u00F3n del campo")
	private Integer campoEntero;

	@Transient
	private UsuarioSibamex usuario;
}