package com.egoist.mall.item.basic.grpc.server;

import com.egoist.mall.grpc.generated.item.basic.ItemBasicProto;
import com.egoist.mall.grpc.generated.item.basic.ItemBasicServiceGrpc;
import com.egoist.mall.item.basic.pojo.Spu;
import com.egoist.mall.item.basic.service.SpuService;
import com.egoist.mall.parent.pojo.EgoistResult;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@GrpcService(ItemBasicProto.class)
public class ItemBasicServiceServer extends ItemBasicServiceGrpc.ItemBasicServiceImplBase {

    @Autowired
    private SpuService spuService;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void querySpuById(ItemBasicProto.QuerySpuByIdRequest request, StreamObserver<ItemBasicProto.QuerySpuByIdResponse> responseObserver) {
        EgoistResult queryResult = spuService.queryById(request.getId());
        final ItemBasicProto.QuerySpuByIdResponse.Builder responseBuilder = ItemBasicProto.QuerySpuByIdResponse.newBuilder();
        responseBuilder.setStatus(queryResult.getStatus());
        responseBuilder.setMsg(queryResult.getMsg());
        if (EgoistResult.isOk(queryResult)) {
            Spu spu = (Spu) queryResult.getData();
            ItemBasicProto.QuerySpuByIdData.Builder dataBuilder = ItemBasicProto.QuerySpuByIdData.newBuilder();
            dataBuilder.setId(spu.getId());
            dataBuilder.setCnName(spu.getCnName());
            dataBuilder.setBrandId(spu.getBrandId());
            dataBuilder.setOriginCountryId(spu.getOriginCountryId());
            dataBuilder.setProductionCountryId(spu.getProductionCountryId());
            dataBuilder.setCategoryId(spu.getCategoryId());
            responseBuilder.setData(dataBuilder);
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
