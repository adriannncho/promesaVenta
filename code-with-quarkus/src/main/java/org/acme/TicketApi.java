package org.acme;

import com.itextpdf.text.DocumentException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.domain.PromesaDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.service.TicketService;

@Path("/internal")
public class TicketApi {

    @Inject
    TicketService ticketService;

    @POST
    @Path("/pdf/promesaVenta")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Se generó correctamente el ticket del pedido."
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Error en recursos suministrados",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(
                                    properties = {
                                            @SchemaProperty(
                                                    name = "errors",
                                                    example = """
                                                            [
                                                                "El número de la comanda (ticket) debe ser positivo."
                                                            ]
                                                            """
                                            )
                                    }))),
                    @APIResponse(
                            responseCode = "404",
                            description = "El número de la comanda no fue encontrado",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(
                                    properties = {
                                            @SchemaProperty(
                                                    name = "detail",
                                                    example = "No se encontraron comandas."
                                            )
                                    }))),
                    @APIResponse(
                            responseCode = "500",
                            description = "Error interno de servidor",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON
                            ))
            }
    )
    @Operation(
            summary = "Descargar comanda de pedido.",
            description = "Se genera la comanda del pedido"
    )
    public Response pdfMerchandiseReceipt(@Valid PromesaDTO promesaDTO) throws DocumentException {
        return Response.status(Response.Status.OK)
              //  .entity(ticketService.printMerchandiseReceipt(promesaDTO))
                .type("application/pdf")
                .header("Content-Disposition", "attachment; filename=comanda.pdf")
                .build();
    }
}
