class DigitalHouseManager(
    var listaAlunos: MutableList<Aluno>,
    var listaProfessores: MutableList<Professor>,
    var listaCursos: MutableList<Curso>,
    var listaMatriculas: MutableList<Matricula>
) {
    fun registrarCurso(c: Curso){
        listaCursos.add(c)
        println("O registro do curso foi efetuado!")
    }
    fun excluirCurso(code: Int){
        listaCursos.removeIf { it.codigoCurso == code}
            println("O curso foi excluído!")
    }
    fun registrarProfessorAdjunto(adjunto: ProfessorAdjunto){
        listaProfessores.add(adjunto)
        println("Registro do(a) professor(a) adjunto(a) finalizado.")
    }
    fun registrarProfessorTitular(titular: ProfessorTitular){
        listaProfessores.add(titular)
        println("Registro do(a) professor(a) titular finalizado.")
    }
    fun excluirProfessor(codigoP: Int){
        listaProfessores.removeIf { it.codigoProfessor == codigoP }
        println("Professor foi excluido com sucesso!")
    }
    fun registrarAluno(estudante: Aluno){
        listaAlunos.add(estudante)
        println("${estudante.nome} foi registrado(a) na Digital House!")
    }
    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        listaCursos.forEach{
            if(it.codigoCurso == codigoCurso){
                listaAlunos.forEach{ aluno ->
                    if(aluno.codigoAluno == codigoAluno){
                        if (it.adicionarUmAluno(aluno)){
                            var matri = Matricula(aluno, it)
                            listaMatriculas.add(matri)
                        }
                    }
                }
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        listaProfessores.forEach{
            if(it.codigoProfessor == codigoProfessorTitular){
                listaCursos.forEach{ curso ->
                    if(curso.codigoCurso == codigoCurso){
                        curso.profTitular = it as ProfessorTitular
                    }
                }
            }
            if(it.codigoProfessor == codigoProfessorAdjunto){
                listaCursos.forEach{ curso ->
                    if(curso.codigoCurso == codigoCurso){
                        curso.profAdjunto = it as ProfessorAdjunto
                    }
                }
            }
        }

    }

}