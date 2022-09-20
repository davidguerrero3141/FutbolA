package com.futbolA.Api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_jugador;
	
	@Column(length = 30, name = "numero_documento", nullable = false)
	private String numero_documento;
	
	@Column(length = 2, name = "tipo_documento", nullable = false)
	private String tipo_documento;
	
	@Column(length = 50, name = "nombre", nullable = false)
	private String nombre;
	
	@Column(length = 50, name ="apellido",nullable = false)
	private String apellido;
	
	private Boolean estado;

	public long getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(long id_jugador) {
		this.id_jugador = id_jugador;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
