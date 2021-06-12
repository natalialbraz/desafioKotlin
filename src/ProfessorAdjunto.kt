class ProfessorAdjunto(override val nome: String,
                       override val sobrenome: String,
                       override val tempoDeCasa: Int,
                       override val codigoProfessor: Int,
                        var qtdeHorasMonitoria: Int): Professor() {

}