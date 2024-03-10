import java.sql.*;
import java.util.Scanner;

public class crud {

    private static Scanner scanner = new Scanner(System.in);
    private static mysqlconnection conn = new mysqlconnection();

    public static void main(String[] args) {
        int opcao;

        while (true) {
            System.out.println("\nMenu CRUD:");
            System.out.println("1. Operações com Aluno");
            System.out.println("2. Operações com Professor");
            System.out.println("3. Operações com Curso");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    alunoCrud();
                    break;
                case 2:
                    professorCrud();
                    break;
                case 3:
                    cursoCrud();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void alunoCrud() {
        System.out.println("\nOperações com Aluno:");
        System.out.println("1. Inserir Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Atualizar Aluno");
        System.out.println("4. Deletar Aluno");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                inserirAluno();
                break;
            case 2:
                listarAlunos();
                break;
            case 3:
                atualizarAluno();
                break;
            case 4:
                deletarAluno();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void inserirAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Endereço do aluno: ");
        String endereco = scanner.nextLine();
        System.out.print("Data de matrícula (AAAA-MM-DD): ");
        String dataMatricula = scanner.nextLine();

        String sql = "INSERT INTO alunos (nome, idade, endereco, dataMatricula) VALUES (?, ?, ?, ?)";
        try {
            conn.OpenDatabase();
            PreparedStatement prepStat = conn.getPreparedStatement(sql);
            prepStat.setString(1, nome);
            prepStat.setInt(2, idade);
            prepStat.setString(3, endereco);
            prepStat.setDate(4, Date.valueOf(dataMatricula));

            int rowsAffected = prepStat.executeUpdate();
            System.out.println(rowsAffected + " linha(s) inserida(s).");
        } catch (Exception e) {
            System.out.println("Erro durante a inserção: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static void listarAlunos() {
        String sql = "SELECT * FROM alunos";
        try {
            conn.OpenDatabase();
            Statement stmt = conn.getDbConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
    
            while (rs.next()) {
                int ra = rs.getInt("ra");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                Date dataMatricula = rs.getDate("dataMatricula");
                
                System.out.println("RA: " + ra + ", Nome: " + nome + ", Idade: " + idade +
                                   ", Endereço: " + endereco + ", Data de Matrícula: " + dataMatricula);
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a listagem de alunos: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void atualizarAluno() {
        System.out.print("Informe o RA do aluno a ser atualizado: ");
        int ra = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo nome do aluno: ");
        String nome = scanner.nextLine();
        
        System.out.print("Nova idade do aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo endereço do aluno: ");
        String endereco = scanner.nextLine();
        
        System.out.print("Nova data de matrícula (AAAA-MM-DD): ");
        String dataMatricula = scanner.nextLine();
    
        String sql = "UPDATE alunos SET nome = ?, idade = ?, endereco = ?, dataMatricula = ? WHERE ra = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, endereco);
            stmt.setDate(4, Date.valueOf(dataMatricula));
            stmt.setInt(5, ra);
            
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " linha(s) atualizada(s).");
        } catch (SQLException e) {
            System.out.println("Erro durante a atualização do aluno: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void deletarAluno() {
        System.out.print("Informe o RA do aluno a ser excluído: ");
        int ra = scanner.nextInt();
        scanner.nextLine();
    
        String sql = "DELETE FROM alunos WHERE ra = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setInt(1, ra);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Aluno com RA " + ra + " foi excluído com sucesso.");
            } else {
                System.out.println("Não foi encontrado um aluno com RA " + ra + ".");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a exclusão do aluno: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void professorCrud() {
        while (true) {
            System.out.println("\nGerenciamento de Professores:");
            System.out.println("1. Inserir Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Atualizar Professor");
            System.out.println("4. Deletar Professor");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (opcao) {
                case 1:
                    inserirProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    atualizarProfessor();
                    break;
                case 4:
                    deletarProfessor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 5.");
                    break;
            }
        }
    }
    private static void inserirProfessor() {
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();
        
        System.out.print("Email do professor: ");
        String email = scanner.nextLine();
        
        System.out.print("Telefone do professor: ");
        String telefone = scanner.nextLine();
    
        String sql = "INSERT INTO professores (nomeProfessor, disciplina, emailProfessor, telefoneProfessor) VALUES (?, ?, ?, ?)";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setString(1, nome);
            stmt.setString(2, disciplina);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
    
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " professor(es) inserido(s).");
        } catch (SQLException e) {
            System.out.println("Erro durante a inserção do professor: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void listarProfessores() {
        String sql = "SELECT * FROM professores";
        try {
            conn.OpenDatabase();
            Statement stmt = conn.getDbConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
    
            while (rs.next()) {
                int id = rs.getInt("idProfessor");
                String nome = rs.getString("nomeProfessor");
                String disciplina = rs.getString("disciplina");
                String email = rs.getString("emailProfessor");
                String telefone = rs.getString("telefoneProfessor");
                
                System.out.println("ID: " + id + ", Nome: " + nome + ", Disciplina: " + disciplina +
                                   ", Email: " + email + ", Telefone: " + telefone);
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a listagem dos professores: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void atualizarProfessor() {
        System.out.print("Informe o ID do professor a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo nome do professor: ");
        String nome = scanner.nextLine();
        
        System.out.print("Nova disciplina: ");
        String disciplina = scanner.nextLine();
        
        System.out.print("Novo email do professor: ");
        String email = scanner.nextLine();
        
        System.out.print("Novo telefone do professor: ");
        String telefone = scanner.nextLine();
    
        String sql = "UPDATE professores SET nomeProfessor = ?, disciplina = ?, emailProfessor = ?, telefoneProfessor = ? WHERE idProfessor = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setString(1, nome);
            stmt.setString(2, disciplina);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setInt(5, id);
    
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " professor(es) atualizado(s).");
        } catch (SQLException e) {
            System.out.println("Erro durante a atualização do professor: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void deletarProfessor() {
        System.out.print("Informe o ID do professor a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        String sql = "DELETE FROM professores WHERE idProfessor = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setInt(1, id);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Professor com ID " + id + " foi excluído com sucesso.");
            } else {
                System.out.println("Não foi encontrado um professor com ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a exclusão do professor: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }

    private static void cursoCrud() {
        while (true) {
            System.out.println("\nGerenciamento de Cursos:");
            System.out.println("1. Inserir Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Atualizar Curso");
            System.out.println("4. Deletar Curso");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcao) {
                case 1:
                    inserirCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    atualizarCurso();
                    break;
                case 4:
                    deletarCurso();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 5.");
                    break;
            }
        }
    }
    private static void inserirCurso() {
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();
        
        System.out.print("Descrição do curso: ");
        String descricaoCurso = scanner.nextLine();
        
        System.out.print("Data de início (AAAA-MM-DD): ");
        String dataInicio = scanner.nextLine();
        
        System.out.print("Data de término (AAAA-MM-DD): ");
        String dataFinal = scanner.nextLine();
    
        String sql = "INSERT INTO cursos (nomeCurso, descricaoCurso, dataInicio, dataFinal) VALUES (?, ?, ?, ?)";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setString(1, nomeCurso);
            stmt.setString(2, descricaoCurso);
            stmt.setDate(3, Date.valueOf(dataInicio));
            stmt.setDate(4, Date.valueOf(dataFinal));
    
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " curso(s) inserido(s).");
        } catch (SQLException e) {
            System.out.println("Erro durante a inserção do curso: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void listarCursos() {
        String sql = "SELECT * FROM cursos";
        try {
            conn.OpenDatabase();
            Statement stmt = conn.getDbConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
    
            while (rs.next()) {
                int idCurso = rs.getInt("idCurso");
                String nomeCurso = rs.getString("nomeCurso");
                String descricaoCurso = rs.getString("descricaoCurso");
                Date dataInicio = rs.getDate("dataInicio");
                Date dataFinal = rs.getDate("dataFinal");
                
                System.out.println("ID: " + idCurso + ", Nome: " + nomeCurso + ", Descrição: " + descricaoCurso +
                                   ", Data de Início: " + dataInicio + ", Data de Término: " + dataFinal);
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a listagem dos cursos: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void atualizarCurso() {
        System.out.print("Informe o ID do curso a ser atualizado: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo nome do curso: ");
        String nomeCurso = scanner.nextLine();
        
        System.out.print("Nova descrição do curso: ");
        String descricaoCurso = scanner.nextLine();
        
        System.out.print("Nova data de início (AAAA-MM-DD): ");
        String dataInicio = scanner.nextLine();
        
        System.out.print("Nova data de término (AAAA-MM-DD): ");
        String dataFinal = scanner.nextLine();
    
        String sql = "UPDATE cursos SET nomeCurso = ?, descricaoCurso = ?, dataInicio = ?, dataFinal = ? WHERE idCurso = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setString(1, nomeCurso);
            stmt.setString(2, descricaoCurso);
            stmt.setDate(3, Date.valueOf(dataInicio));
            stmt.setDate(4, Date.valueOf(dataFinal));
            stmt.setInt(5, idCurso);
    
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " curso(s) atualizado(s).");
        } catch (SQLException e) {
            System.out.println("Erro durante a atualização do curso: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
    private static void deletarCurso() {
        System.out.print("Informe o ID do curso a ser excluído: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine();
    
        String sql = "DELETE FROM cursos WHERE idCurso = ?";
        try {
            conn.OpenDatabase();
            PreparedStatement stmt = conn.getPreparedStatement(sql);
    
            stmt.setInt(1, idCurso);
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Curso com ID " + idCurso + " foi excluído com sucesso.");
            } else {
                System.out.println("Não foi encontrado um curso com ID " + idCurso + ".");
            }
        } catch (SQLException e) {
            System.out.println("Erro durante a exclusão do curso: " + e.getMessage());
        } finally {
            try {
                conn.CloseDatabase();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}
