package com.paypal.wallet_service.schedular;


import com.paypal.wallet_service.entity.WalletHold;
import com.paypal.wallet_service.repository.WalletHoldRepository;
import com.paypal.wallet_service.repository.WalletRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HoldExpirySchedular {

    private final WalletHoldRepository walletHoldRepository;
//    private final WalletService walletService;

    public HoldExpirySchedular(WalletHoldRepository walletHoldRepository){
        this.walletHoldRepository=walletHoldRepository;
    }
    @Scheduled(fixedRateString = "${wallet.hold.expiry.scan-rate-ms:60000}")
    public void expireOldHolds(){
        LocalDateTime now=LocalDateTime.now();
        List<WalletHold> expired=walletHoldRepository.findByStatusAndExpiresAtBefore("ACTIVE",now);

        for(WalletHold hold:expired){
            String ref=hold.getHoldReference();
            try{
//                walletService.releaseHold(ref);
                System.out.println("expired hold released"+ref);

            }
            catch (Exception e){
                System.out.println("failed to release expired hold"+e.getMessage());
            }
        }
    }
}
