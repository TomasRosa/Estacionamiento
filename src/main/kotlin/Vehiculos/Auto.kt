package Vehiculos

import Enum.TipoHorario
import Enum.TipoVehiculo
import Sistema.Vehiculo

/**
 Clase hija de Vehiculo, auto.
 */
class Auto(
    marca: String,
    modelo: String,
    patente: String,
    color: String,
    horaEntrada: Int,
    horaSalida: Int,
    tipoVehiculo: TipoVehiculo = TipoVehiculo.AUTO,
    tipoHorario: TipoHorario // No asignamos un valor por defecto
) : Vehiculo(marca, modelo, patente, color, horaEntrada, horaSalida, tipoVehiculo, tipoHorario)
