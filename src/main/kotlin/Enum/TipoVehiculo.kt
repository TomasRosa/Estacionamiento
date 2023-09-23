package Enum

/**
 Enum para determinar el tipo de vehiculo.
 */
enum class TipoVehiculo (val adicional: Int)
{
    MOTO(50),
    AUTO(100),
    CAMIONETA(250);
}