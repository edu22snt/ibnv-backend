package com.br.ibnv_backend.service;

import com.br.ibnv_backend.service.dto.*;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

@Service
public class RelatorioService {

    public ByteArrayInputStream gerarRelatorioFinanceiro(List<FinanceiroDTO> lista, String filtro) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BigDecimal total = BigDecimal.ZERO;

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 10);
            Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD);

            Paragraph tituloP = new Paragraph("IBNV - Relatório Financeiro", titulo);
            tituloP.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloP);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            document.add(new Paragraph("Filtro: " + filtro, normal));
            document.add(new Paragraph("Data: " + LocalDate.now().format(formatter), normal));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);

            table.setWidths(new float[]{
                    3, // Tipo
                    2, // Categoria
                    2, // Data
                    2, // Valor
                    2, // Descrição
            });

            Stream.of("Tipo", "Categoria", "Data", "Valor", "Descrição")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(Color.LIGHT_GRAY);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    });

            for (FinanceiroDTO item : lista) {
                BigDecimal valorBase = item.getValor();

                table.addCell(item.getTipo());
                table.addCell(item.getCategoria());
                table.addCell(item.getData().toString());
                table.addCell(criarCelulaMoeda(valorBase));
                table.addCell(item.getDescricao());

                total = total.add(valorBase);
            }

            PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL", headerFont));
            totalLabel.setColspan(4);
            totalLabel.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalLabel.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalLabel);

            PdfPCell totalValor = criarCelulaMoeda(total);
            totalValor.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalValor);

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream gerarRelatorioMembros(List<MembroDTO> lista, String filtro) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BigDecimal total = BigDecimal.ZERO;

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 10);
            Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD);

            Paragraph tituloP = new Paragraph("GI3 - Relatório Repasse Bancorbrás", titulo);
            tituloP.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloP);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            document.add(new Paragraph("Filtro: " + filtro, normal));
            document.add(new Paragraph("Data: " + LocalDate.now().format(formatter), normal));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            table.setWidths(new float[]{
                    3, // Nome
                    2, // Líder direto
                    2, // Email
                    2, // Telefone
                    2, // Data de nascimento
                    2, // Ativo
            });

            Stream.of("Nome", "Líder direto", "Email", "Telefone", "Data de nascimento", "Ativo")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(Color.LIGHT_GRAY);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    });

            for (MembroDTO item : lista) {

                table.addCell(item.getNome());
                table.addCell(item.getLiderDireto());
                table.addCell(item.getEmail());
                table.addCell(item.getNumTelefone());
                table.addCell(item.getDataNascimento().toString());
                table.addCell(item.getAtivo() == 1 ? "Sim" : "Não");
            }

            PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL", headerFont));
            totalLabel.setColspan(9);
            totalLabel.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalLabel.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalLabel);

            PdfPCell totalValor = criarCelulaMoeda(total);
            totalValor.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalValor);

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream gerarRelatorioCelula(List<CelulaDTO> lista, String filtro) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BigDecimal total = BigDecimal.ZERO;

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 10);
            Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD);

            Paragraph tituloP = new Paragraph("GI3 - Relatório Repasse HS", titulo);
            tituloP.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloP);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            document.add(new Paragraph("Filtro: " + filtro, normal));
            document.add(new Paragraph("Data: " + LocalDate.now().format(formatter), normal));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            table.setWidths(new float[]{
                    3, // Nome da celula
                    2, // Líder
                    2, // Endereço
                    2, // Dia
                    2, // Horario
                    2, // Anfitrião
            });

            Stream.of("Nome da celula", "Líder", "Endereço", "Dia", "Horario", "Anfitrião")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(Color.LIGHT_GRAY);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    });

            for (CelulaDTO item : lista) {
                table.addCell(item.getNome());
                table.addCell(item.getLider());
                table.addCell(item.getEndereco().getLogradouro());
                table.addCell(item.getDiaSemana());
                table.addCell(item.getHorario());
                table.addCell(item.getAnfitriao());
            }

            PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL", headerFont));
            totalLabel.setColspan(7);
            totalLabel.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalLabel.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalLabel);

            PdfPCell totalValor = criarCelulaMoeda(total);
            totalValor.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalValor);

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream gerarRelatorioEventos(List<EventoDTO> lista, String filtro) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BigDecimal total = BigDecimal.ZERO;

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 10);
            Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD);

            Paragraph tituloP = new Paragraph("IBNV - Relatório de Eventos", titulo);
            tituloP.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloP);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            document.add(new Paragraph("Filtro: " + filtro, normal));
            document.add(new Paragraph("Data: " + LocalDate.now().format(formatter), normal));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            table.setWidths(new float[]{
                    2, // Nome
                    3, // Tipo
                    2, // Data
                    4, // Descrição
            });

            Stream.of("Nome", "Tipo", "Data", "Descrição")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(Color.LIGHT_GRAY);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    });

            for (EventoDTO item : lista) {

                table.addCell(item.getNome());
                table.addCell(item.getTipo());
                table.addCell(item.getData().toString());
                table.addCell(item.getDescricao());
            }

            PdfPCell totalLabel = new PdfPCell(new Phrase("TOTAL", headerFont));
            totalLabel.setColspan(4);
            totalLabel.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalLabel.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalLabel);

            PdfPCell totalValor = criarCelulaMoeda(total);
            totalValor.setBackgroundColor(Color.LIGHT_GRAY);
            table.addCell(totalValor);

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    public ByteArrayInputStream gerarRelatorioMinisterio(List<MinisterioDTO> lista, String filtro) {

        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        BigDecimal total = BigDecimal.ZERO;

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font normal = new Font(Font.HELVETICA, 10);
            Font headerFont = new Font(Font.HELVETICA, 10, Font.BOLD);

            Paragraph tituloP = new Paragraph("GI3 - Relatório Lista Vendedores", titulo);
            tituloP.setAlignment(Element.ALIGN_CENTER);
            document.add(tituloP);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            document.add(new Paragraph("Filtro: " + filtro, normal));
            document.add(new Paragraph("Data: " + LocalDate.now().format(formatter), normal));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            table.setWidths(new float[]{
                    3, // Nome
                    2, // Tipo
                    3, // Lider
            });

            Stream.of("Nome", "Tipo", "Lider")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                        cell.setBackgroundColor(Color.LIGHT_GRAY);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    });

            for (MinisterioDTO item : lista) {

                table.addCell(item.getNome());
                table.addCell(item.getTipo());
                table.addCell(item.getLider().getNome());
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    private PdfPCell criarCelulaMoeda(BigDecimal valor) {
        PdfPCell cell = new PdfPCell(new Phrase(formatarMoeda(valor)));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setNoWrap(true);
        return cell;
    }

    private String formatarMoeda(BigDecimal valor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
    }

}
