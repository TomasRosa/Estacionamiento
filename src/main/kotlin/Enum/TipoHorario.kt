package Enum
/**
 Enum para determinar el atributo de cada vehiculo segun el horario en el que se estacionen.
 */
enum class TipoHorario (val precioPorHora: Int)
{
    MANIANA(150),
    TARDE(250),
    NOCHE(300);
}