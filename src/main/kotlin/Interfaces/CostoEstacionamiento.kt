package Interfaces

import Sistema.Vehiculo

interface CostoEstacionamiento
{
    fun calcularCosto (vehiculo: Vehiculo): Int
}