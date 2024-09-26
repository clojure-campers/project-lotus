(ns lotus.clj.lotus
  (:require [seesaw.core :as s]))

(defn centered-label [text color]
  (doto (s/label :text text
                 :foreground color)
    (s/config! :h-text-position :center)))

(defn centered-content []
  (let [main-panel (s/vertical-panel
              :items [(s/flow-panel
                       :items [(centered-label "Welcome to code lotus" :tan)]
                       :background :black)])]
    main-panel))

(defn lotus-bloom []
  (let [main-frame (s/frame :title "Code Lotus")
        main-content (centered-content)]
    (-> main-frame
        (s/config!
         :content (s/border-panel
                   :center main-content)
         :minimum-size [450 :by 400])
        s/pack!
        s/show!)))

(defn -main [& args]
  (s/invoke-later (lotus-bloom)))