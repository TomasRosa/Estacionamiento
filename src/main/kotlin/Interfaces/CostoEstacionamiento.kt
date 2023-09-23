package Interfaces

import Sistema.Vehiculo

/**
 Interfaz para calcular el costo del estacionamiento.
 */
interface CostoEstacionamiento
{
    fun calcularCosto (vehiculo: Vehiculo): Int
}