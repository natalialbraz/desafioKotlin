fun main() {
    // instancia vazia da classe DigitalHouseManager
    val gerencia = DigitalHouseManager(mutableListOf(), mutableListOf(), mutableListOf(), mutableListOf())
    println("Bem vinda a Digital House!")

    // registro dos professores
    val profT1 = ProfessorTitular("Americo", "Tristao", 5, 1, "Front-end")
    gerencia.registrarProfessorTitular(profT1)
    val profT2 = ProfessorTitular("Adrielle", "Carvalho", 3, 2, "Back-end")
    gerencia.registrarProfessorTitular(profT2)
    val profA1 = ProfessorAdjunto("Thiago", "Santos", 6, 3, 20)
    val profA2 = ProfessorAdjunto("Savio", "Ribas", 2, 4, 5)
    gerencia.registrarProfessorAdjunto(profA1)
    gerencia.registrarProfessorAdjunto(profA2)
    println("Dados dos professores da Digital House: ")
    println("     Nome       Sobrenome      Tempo de Casa     Codigo do Professor")
    gerencia.listaProfessores.forEach {
        println("   ${it.nome}       ${it.sobrenome}           ${it.tempoDeCasa}                 ${it.codigoProfessor}")
    }

    // registro dos cursos
    val curso1 = Curso("Full Stack", 20001, 3)
    val curso2 = Curso("Android", 20002, 2)
    gerencia.registrarCurso(curso1)
    gerencia.registrarCurso(curso2)

    // alocação de professores
    gerencia.alocarProfessores(20001, 1, 3)
    gerencia.alocarProfessores(20002, 2, 4)
    gerencia.listaCursos.forEach {
        println("O curso de ${it.nome} tera ${it.profTitular.nome} como professor(a) titular e ${it.profAdjunto.nome} como professor(a) adjunto.")
    }

    // registro de alunos
    val aluno1 = Aluno("Camila", "Santos", 111)
    val aluno2 = Aluno("Paulo", "Coelho", 222)
    val aluno3 = Aluno("Barbara", "Duarte", 333)
    val aluno4 = Aluno("Ana", "Cardoso", 444)
    val aluno5 = Aluno("Rafael", "Oliveira", 555)
    gerencia.registrarAluno(aluno1)
    gerencia.registrarAluno(aluno2)
    gerencia.registrarAluno(aluno3)
    gerencia.registrarAluno(aluno4)
    gerencia.registrarAluno(aluno5)

    // matriculando alunos no curso de Full Stack
    gerencia.matricularAluno(111, 20001)
    gerencia.matricularAluno(222, 20001)
    // matriculando alunos no curso de Android
    gerencia.matricularAluno(333, 20002)
    gerencia.matricularAluno(444, 20002)
    gerencia.matricularAluno(555, 20002)
    println("Lista de alunos(as) matriculados(as) no curso de Full Stack: ")
    curso1.alunosMatriculados.forEach {
        println("${it.nome} ${it.sobrenome}")
    }
    println("Lista de alunos(as) matriculados(as) no curso de Android: ")
    curso2.alunosMatriculados.forEach {
        println("${it.nome} ${it.sobrenome}")
    }
    println("Deseja consultar a lista de matricula dos cursos da Digital House? ")
    print("Digite [1] para SIM e [2] para NÃO: ")
    val op = readLine()?.toInt()
    when (op) {
        1 -> gerencia.listaMatriculas.forEach {
                println("${it.aluno.nome} ${it.aluno.sobrenome} foi matriculado(a) no curso de ${it.curso.nome} em ${it.dateDeMatricula}")
            }
        2 -> println("Processo finalizado. A Digital House agradece pela preferencia! ")
    }

    // testando outras funcionalidades
    // excluir professor
    val profTeste = ProfessorTitular("Hugo", "Nogueira", 12, 44, "Protocolos")
    gerencia.registrarProfessorTitular(profTeste)
    gerencia.listaProfessores.forEach{
        println("${it.nome}")
    }
    gerencia.excluirProfessor(44)
    gerencia.listaProfessores.forEach{
        println("${it.nome}")
    }

    // excluir aluno
    val alunoTeste = Aluno("Carol", "Silva", 987)
    gerencia.registrarAluno(alunoTeste)
    val alunoExtra = Aluno("Mariana", "Lima", 212)
    gerencia.registrarAluno(alunoExtra)
    val cursoTeste = Curso("IOS", 234, 5)
    gerencia.registrarCurso(cursoTeste)
    gerencia.matricularAluno(987, 234)
    gerencia.matricularAluno(212, 234)
    println("Lista de alunos matriculados no curso de IOS: ")
    cursoTeste.alunosMatriculados.forEach{
        println("${it.nome}")
    }
    cursoTeste.excluirAluno(alunoTeste)
    println("Após excluir:")
    cursoTeste.alunosMatriculados.forEach{
        println("${it.nome}")
    }

    // excluir curso
    println("Lista de cursos: ")
    gerencia.listaCursos.forEach{
        println("${it.nome}")
    }
    gerencia.excluirCurso(234)
    println("Lista de cursos após exclusão: ")
    gerencia.listaCursos.forEach{
        println("${it.nome}")
    }

}