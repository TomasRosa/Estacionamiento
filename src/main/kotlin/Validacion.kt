class Validacion
{
    fun validarPatente(patente: String): Boolean
    {
        val regex = Regex("^[A-Z]{3}\\s\\d{3}$")  // Agregamos \\s para representar un espacio
        return regex.matches(patente)
    }
    fun esOpcionValida(entrada: String?): Boolean
    {
        return try
        {
            val opcion = entrada?.toInt() // Utilizamos ?. para tratar de convertir a Int
            opcion != null && opcion in 1..7 // Verificamos si no es nulo y está en el rango válido
        }
        catch (e: NumberFormatException)
        {
            false
        }
    }
    fun validarHoraSalidaMayorHoraEntrada (horaEntrada: Int,horaSalida: Int) : Boolean
    {
        return horaSalida > horaEntrada
    }
}