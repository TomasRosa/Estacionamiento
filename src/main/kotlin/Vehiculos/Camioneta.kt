package Vehiculos

import Enum.TipoHorario
import Enum.TipoVehiculo
import Sistema.Vehiculo

/**
    Clase hija de Vehiculo, camioneta.
 */
class Camioneta(
    marca: String,
    modelo: String,
    patente: String,
    color: String,
    horaEntrada: Int,
    horaSalida: Int,
    tipoVehiculo: TipoVehiculo = TipoVehiculo.CAMIONETA,
    tipoHorario: TipoHorario // Asigna el tipo de vehículo correspondiente
) : Vehiculo(marca, modelo, patente, color, horaEntrada, horaSalida, tipoVehiculo,tipoHorario)